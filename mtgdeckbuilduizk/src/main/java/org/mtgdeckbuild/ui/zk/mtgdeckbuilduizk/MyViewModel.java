package org.mtgdeckbuild.ui.zk.mtgdeckbuilduizk;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.CheckEvent;

import ws.models.CardList;
import ws.models.CardService;
import ws.models.CardServiceImpl;
import ws.models.Datum;

public class MyViewModel {

	private String name = null;
	// colors
	private boolean isWhite = false;
	private boolean isBlue = false;
	private boolean isBlack = false;
	private boolean isRed = false;
	private boolean isGreen = false;
	private boolean isIncolor = false;
	// cost
	private boolean isZero = false;
	private boolean isOne = false;
	private boolean isTwo = false;
	private boolean isThree = false;
	private boolean isFour = false;
	private boolean isFive = false;
	private boolean isSix = false;
	private boolean isSeven = false;
	private boolean isMore = false;
	// rarity
	private boolean isCommon = false;
	private boolean isUnCommon = false;
	private boolean isRare = false;
	private boolean isMitic = false;
	// types
	private boolean isArtifact = false;
	private boolean isCreature = false;
	private boolean isEnchant = false;
	private boolean isPlanesWalker = false;
	private boolean isGround = false;
	private boolean isInstantMagic = false;
	private boolean isSpell = false;
	// controllers
	private CardList cardListHeader;
	private List<Datum> deckList = new ArrayList<Datum>();
	private List<Datum> cardList;
	private Datum selectedCard;
	private Datum selectedDeck;
	private boolean isButtons = false;
	private boolean isButtonsDeck = false;
	private Integer qtyOnDeck = 0;
	private Integer qtyOnDeckS = 0;
	private Integer totalOnDeck = 0;
	private CardService cardService = new CardServiceImpl();
	private Integer qtyMana0 = 0;
	private Integer qtyMana1 = 0;
	private Integer qtyMana2 = 0;
	private Integer qtyMana3 = 0;
	private Integer qtyMana4 = 0;
	private Integer qtyMana5 = 0;
	private Integer qtyMana6 = 0;
	private Integer qtyMana7 = 0;
	private Integer qtyMana8 = 0;
	private BigDecimal pRed = BigDecimal.ZERO;
	private BigDecimal pWhite = BigDecimal.ZERO;
	private BigDecimal pBlue = BigDecimal.ZERO;
	private BigDecimal pGreen = BigDecimal.ZERO;
	private BigDecimal pBlack = BigDecimal.ZERO;
	private BigDecimal pIncolor = BigDecimal.ZERO;
	private Integer qtdA = 0;
	private Integer qtdC = 0;
	private Integer qtdE = 0;
	private Integer qtdT = 0;
	private Integer qtdF = 0;
	private Integer qtdM = 0;
	private Integer qtdP = 0;
	
	
	@Init
	public void init() {
	}

	@Command
	@NotifyChange({"cardList", "isButtons", "qtyOnDeck", "selectedCard"})
	public void doFind() {
		selectedCard = null;
		isButtons = false;
		cardListHeader = cardService.search(name, isWhite, isBlue, isBlack, isRed, isGreen, isIncolor, isZero, isOne, isTwo,
				isThree, isFour, isFive, isSix, isSeven, isMore, isCommon, isUnCommon, isRare, isMitic, isArtifact,
				isCreature, isEnchant, isPlanesWalker, isGround, isInstantMagic, isSpell);
		if(cardListHeader != null)
			cardList = cardListHeader.getData();
		else
			cardList = null;
	}
	
	@Command
	@NotifyChange({ "qtyOnDeck", "deckList", "qtyMana0", "qtyMana1", "qtyMana2", "qtyMana3", "qtyMana4", "qtyMana5",
			"qtyMana6", "qtyMana7", "qtyMana8", "pRed", "pWhite", "pBlue", "pGreen", "pIncolor", "pBlack", "qtdA",
			"qtdC", "qtdE", "qtdT", "qtdF", "qtdM", "qtdP" })
	public void addOne()
	{
		if(selectedCard != null)
		{
			int count = (int)deckList.stream().filter(x -> x.equals(selectedCard)).count();
			if(count < 4)
			{
				deckList.add(selectedCard);
				this.qtyOnDeck = ++count;
				calcStats();
			}
			else 
				System.out.println("Apenas 4 cartas");
		}
	}
	
	@Command
	@NotifyChange({ "qtyOnDeck", "deckList", "qtyMana0", "qtyMana1", "qtyMana2", "qtyMana3", "qtyMana4", "qtyMana5",
		"qtyMana6", "qtyMana7", "qtyMana8", "pRed", "pWhite", "pBlue", "pGreen", "pIncolor", "pBlack", "qtdA",
		"qtdC", "qtdE", "qtdT", "qtdF", "qtdM", "qtdP" })
	public void addFour()
	{
		if(selectedCard != null)
		{
			int count = (int)deckList.stream().filter(x -> x.equals(selectedCard)).count();
			count = 4 - count;
			if(count == 0)
				System.out.println("Apenas 4 Cartas");
			for(int i = 0; i < count; i++) 
			{
				deckList.add(selectedCard);	
			}
			this.qtyOnDeck+= count;
			calcStats();
		}
	}
	
	@Command
	@NotifyChange({ "qtyOnDeck", "deckList", "qtyMana0", "qtyMana1", "qtyMana2", "qtyMana3", "qtyMana4", "qtyMana5",
		"qtyMana6", "qtyMana7", "qtyMana8", "pRed", "pWhite", "pBlue", "pGreen", "pIncolor", "pBlack", "qtdA",
		"qtdC", "qtdE", "qtdT", "qtdF", "qtdM", "qtdP" })
	public void removeOne()
	{
		if(selectedCard != null && deckList.contains(selectedCard))
		{
			deckList.remove(selectedCard);
			this.qtyOnDeck--;
			calcStats();
		}
	}
	
	@Command
	@NotifyChange({ "qtyOnDeck", "deckList", "qtyMana0", "qtyMana1", "qtyMana2", "qtyMana3", "qtyMana4", "qtyMana5",
		"qtyMana6", "qtyMana7", "qtyMana8", "pRed", "pWhite", "pBlue", "pGreen", "pIncolor", "pBlack", "qtdA",
		"qtdC", "qtdE", "qtdT", "qtdF", "qtdM", "qtdP" })
	public void removeAll()
	{
		if(selectedCard != null)
		{			
			while(deckList.contains(selectedCard))
				deckList.remove(selectedCard);
			this.qtyOnDeck = 0;
			calcStats();
		}
	}

	@Command
	@NotifyChange({ "qtyOnDeck", "deckList", "qtyMana0", "qtyMana1", "qtyMana2", "qtyMana3", "qtyMana4", "qtyMana5",
		"qtyMana6", "qtyMana7", "qtyMana8", "pRed", "pWhite", "pBlue", "pGreen", "pIncolor", "pBlack", "qtdA",
		"qtdC", "qtdE", "qtdT", "qtdF", "qtdM", "qtdP" })
	public void addOneS()
	{
		if(selectedDeck != null)
		{
			int count = (int)deckList.stream().filter(x -> x.equals(selectedDeck)).count();
			if(count < 4)
			{
				deckList.add(selectedDeck);
				this.qtyOnDeckS = ++count;
				calcStats();
			}
			else 
				System.out.println("Apenas 4 cartas");
		}
	}
	
	@Command
	@NotifyChange({ "qtyOnDeck", "deckList", "qtyMana0", "qtyMana1", "qtyMana2", "qtyMana3", "qtyMana4", "qtyMana5",
		"qtyMana6", "qtyMana7", "qtyMana8", "pRed", "pWhite", "pBlue", "pGreen", "pIncolor", "pBlack", "qtdA",
		"qtdC", "qtdE", "qtdT", "qtdF", "qtdM", "qtdP" })
	public void addFourS()
	{
		if(selectedDeck != null)
		{
			int count = (int)deckList.stream().filter(x -> x.equals(selectedDeck)).count();
			count = 4 - count;
			if(count == 0)
				System.out.println("Apenas 4 Cartas");
			for(int i = 0; i < count; i++) 
			{
				deckList.add(selectedDeck);	
			}
			this.qtyOnDeckS+= count;
			calcStats();
		}
	}
	
	@Command
	@NotifyChange({ "qtyOnDeck", "deckList", "qtyMana0", "qtyMana1", "qtyMana2", "qtyMana3", "qtyMana4", "qtyMana5",
		"qtyMana6", "qtyMana7", "qtyMana8", "pRed", "pWhite", "pBlue", "pGreen", "pIncolor", "pBlack", "qtdA",
		"qtdC", "qtdE", "qtdT", "qtdF", "qtdM", "qtdP" })
	public void removeOneS()
	{
		if(selectedDeck != null && deckList.contains(selectedDeck))
		{
			deckList.remove(selectedDeck);
			this.qtyOnDeckS--;
			calcStats();
		}
	}
	
	@Command
	@NotifyChange({ "qtyOnDeck", "deckList", "qtyMana0", "qtyMana1", "qtyMana2", "qtyMana3", "qtyMana4", "qtyMana5",
		"qtyMana6", "qtyMana7", "qtyMana8", "pRed", "pWhite", "pBlue", "pGreen", "pIncolor", "pBlack", "qtdA",
		"qtdC", "qtdE", "qtdT", "qtdF", "qtdM", "qtdP" })
	public void removeAllS()
	{
		if(selectedDeck != null)
		{			
			while(deckList.contains(selectedDeck))
				deckList.remove(selectedDeck);
			this.qtyOnDeckS = 0;
			calcStats();
		}
	}
	
	private void calcStats() {
		int qty0 = (int)deckList.stream().filter(x -> x.getCmc() == 0).count();
		int qty1 = (int)deckList.stream().filter(x -> x.getCmc() == 1).count();
		int qty2 = (int)deckList.stream().filter(x -> x.getCmc() == 2).count();
		int qty3 = (int)deckList.stream().filter(x -> x.getCmc() == 3).count();
		int qty4 = (int)deckList.stream().filter(x -> x.getCmc() == 4).count();
		int qty5 = (int)deckList.stream().filter(x -> x.getCmc() == 5).count();
		int qty6 = (int)deckList.stream().filter(x -> x.getCmc() == 6).count();
		int qty7 = (int)deckList.stream().filter(x -> x.getCmc() == 7).count();
		int qty8 = (int)deckList.stream().filter(x -> x.getCmc() > 7).count();
		
		setQtyMana0(qty0);
		setQtyMana1(qty1);
		setQtyMana2(qty2);
		setQtyMana3(qty3);
		setQtyMana4(qty4);
		setQtyMana5(qty5);
		setQtyMana6(qty6);
		setQtyMana7(qty7);
		setQtyMana8(qty8);
		
		int pR = (int)deckList.stream().filter(x -> x.getColorIdentity().contains("R")).count();
		int pW = (int)deckList.stream().filter(x -> x.getColorIdentity().contains("W")).count();
		int pB = (int)deckList.stream().filter(x -> x.getColorIdentity().contains("B")).count();
		int pU = (int)deckList.stream().filter(x -> x.getColorIdentity().contains("U")).count();
		int pG = (int)deckList.stream().filter(x -> x.getColorIdentity().contains("G")).count();
		int pC = (int)deckList.stream().filter(x -> x.getColorIdentity().contains("C")).count();
		
		int count = deckList.size();
		if(count > 0)
		{
			BigDecimal hundred = new BigDecimal(100);
			BigDecimal r = new BigDecimal(pR).divide(new BigDecimal(count), 2, RoundingMode.HALF_UP).multiply(hundred);
			BigDecimal w = new BigDecimal(pW).divide(new BigDecimal(count), 2, RoundingMode.HALF_UP).multiply(hundred);
			BigDecimal b = new BigDecimal(pB).divide(new BigDecimal(count), 2, RoundingMode.HALF_UP).multiply(hundred);
			BigDecimal u = new BigDecimal(pU).divide(new BigDecimal(count), 2, RoundingMode.HALF_UP).multiply(hundred);
			BigDecimal g = new BigDecimal(pG).divide(new BigDecimal(count), 2, RoundingMode.HALF_UP).multiply(hundred);
			BigDecimal c = new BigDecimal(pC).divide(new BigDecimal(count), 2, RoundingMode.HALF_UP).multiply(hundred);
		
			setpBlack(b);
			setpBlue(u);
			setpGreen(g);
			setpIncolor(c);
			setpRed(r);
			setpWhite(w);
		}
		
		int qT = (int)deckList.stream().filter(x -> x.getTypeLine().contains("Land")).count();
		int qE = (int)deckList.stream().filter(x -> x.getTypeLine().contains("Enchantment")).count();
		int qC = (int)deckList.stream().filter(x -> x.getTypeLine().contains("Creature")).count();
		int qP = (int)deckList.stream().filter(x -> x.getTypeLine().contains("Planeswalker")).count();
		int qI = (int)deckList.stream().filter(x -> x.getTypeLine().contains("Instant")).count();
		int qM = (int)deckList.stream().filter(x -> x.getTypeLine().contains("Sorcery")).count();
		int qA = (int)deckList.stream().filter(x -> x.getTypeLine().contains("Artifact")).count();
		
		setQtdA(qA);
		setQtdE(qE);
		setQtdC(qC);
		setQtdP(qP);
		setQtdF(qM);
		setQtdM(qI);
		setQtdT(qT);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isWhite() {
		return isWhite;
	}

	@Command
	public void setWhite(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isWhite = change.isChecked();
	}

	public boolean isBlue() {
		return isBlue;
	}

	@Command
	public void setBlue(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isBlue = change.isChecked();
	}

	public boolean isBlack() {
		return isBlack;
	}

	@Command
	public void setBlack(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isBlack = change.isChecked();
	}

	public boolean isRed() {
		return isRed;
	}

	@Command
	public void setRed(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isRed = change.isChecked();
	}

	public boolean isGreen() {
		return isGreen;
	}

	@Command
	public void setGreen(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isGreen = change.isChecked();
	}

	public boolean isIncolor() {
		return isIncolor;
	}

	@Command
	public void setIncolor(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isIncolor = change.isChecked();
	}

	public boolean isZero() {
		return isZero;
	}

	@Command
	public void setZero(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isZero = change.isChecked();
	}

	public boolean isOne() {
		return isOne;
	}

	@Command
	public void setOne(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isOne = change.isChecked();
	}

	public boolean isTwo() {
		return isTwo;
	}

	@Command
	public void setTwo(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isTwo = change.isChecked();
	}

	public boolean isThree() {
		return isThree;
	}

	@Command
	public void setThree(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isThree = change.isChecked();
	}

	public boolean isFour() {
		return isFour;
	}

	@Command
	public void setFour(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isFour = change.isChecked();
	}

	public boolean isFive() {
		return isFive;
	}

	@Command
	public void setFive(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isFive = change.isChecked();
	}

	public boolean isSix() {
		return isSix;
	}

	@Command
	public void setSix(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isSix = change.isChecked();
	}

	public boolean isSeven() {
		return isSeven;
	}

	@Command
	public void setSeven(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isSeven = change.isChecked();
	}

	public boolean isMore() {
		return isMore;
	}

	@Command
	public void setMore(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isMore = change.isChecked();
	}

	public boolean isCommon() {
		return isCommon;
	}

	@Command
	public void setCommon(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isCommon = change.isChecked();
	}

	public boolean isUnCommon() {
		return isUnCommon;
	}

	@Command
	public void setUnCommon(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isUnCommon = change.isChecked();
	}

	public boolean isRare() {
		return isRare;
	}

	@Command
	public void setRare(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isRare = change.isChecked();
	}

	public boolean isMitic() {
		return isMitic;
	}

	@Command
	public void setMitic(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isMitic = change.isChecked();
	}

	public boolean isArtifact() {
		return isArtifact;
	}

	@Command
	public void setArtifact(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isArtifact = change.isChecked();
	}

	public boolean isCreature() {
		return isCreature;
	}

	@Command
	public void setCreature(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isCreature = change.isChecked();
	}

	public boolean isEnchant() {
		return isEnchant;
	}

	@Command
	public void setEnchant(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isEnchant = change.isChecked();
	}

	public boolean isPlanesWalker() {
		return isPlanesWalker;
	}

	@Command
	public void setPlanesWalker(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isPlanesWalker = change.isChecked();
	}

	public boolean isGround() {
		return isGround;
	}

	@Command
	public void setGround(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isGround = change.isChecked();
	}

	public boolean isInstantMagic() {
		return isInstantMagic;
	}

	@Command
	public void setInstantMagic(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isInstantMagic = change.isChecked();
	}

	public boolean isSpell() {
		return isSpell;
	}

	@Command
	public void setSpell(@ContextParam(ContextType.TRIGGER_EVENT) CheckEvent change) {
		this.isSpell = change.isChecked();
	}
	
	public Integer getTotalOnDeck() {
		return totalOnDeck;
	}

	public void setTotalOnDeck(Integer totalOnDeck) {
		this.totalOnDeck = totalOnDeck;
	}

	public Integer getQtyOnDeck() {
		return qtyOnDeck;
	}

	public void setQtyOnDeck(Integer qtyOnDeck) {
		this.qtyOnDeck = qtyOnDeck;
	}

	public boolean getIsButtons() {
		return isButtons;
	}

	public void setButtons(boolean isButtons) {
		this.isButtons = isButtons;
	}

	public List<Datum> getCardList() {
		return cardList;
	}

	public void setCardList(List<Datum> cardList) {
		this.cardList = cardList;
	}

	public Datum getSelectedCard() {
		return selectedCard;
	}
	
	@NotifyChange({"selectedCard", "isButtons", "qtyOnDeck"})
	public void setSelectedCard(Datum selectedCard) {
		this.selectedCard = selectedCard;
		this.isButtons = true;
		this.qtyOnDeck = (int)deckList.stream().filter(x -> x.equals(selectedCard)).count();
	}

	public Datum getSelectedDeck() {
		return selectedDeck;
	}

	@NotifyChange({"selectedDeck", "isButtonsDeck", "qtyOnDeckS"})
	public void setSelectedDeck(Datum selectedDeck) {
		this.selectedDeck = selectedDeck;
		this.qtyOnDeckS = (int)deckList.stream().filter(x -> x.equals(selectedDeck)).count();
		this.isButtonsDeck = true;
	}

	public List<Datum> getDeckList() {
		return deckList;
	}

	public void setDeckList(List<Datum> deckList) {
		this.deckList = deckList;
	}

	public Integer getQtyMana1() {
		return qtyMana1;
	}

	public void setQtyMana1(Integer qtyMana1) {
		this.qtyMana1 = qtyMana1;
	}

	public Integer getQtyMana2() {
		return qtyMana2;
	}

	public void setQtyMana2(Integer qtyMana2) {
		this.qtyMana2 = qtyMana2;
	}

	public Integer getQtyMana3() {
		return qtyMana3;
	}

	public void setQtyMana3(Integer qtyMana3) {
		this.qtyMana3 = qtyMana3;
	}

	public Integer getQtyMana4() {
		return qtyMana4;
	}

	public void setQtyMana4(Integer qtyMana4) {
		this.qtyMana4 = qtyMana4;
	}

	public Integer getQtyMana5() {
		return qtyMana5;
	}

	public void setQtyMana5(Integer qtyMana5) {
		this.qtyMana5 = qtyMana5;
	}

	public Integer getQtyMana6() {
		return qtyMana6;
	}

	public void setQtyMana6(Integer qtyMana6) {
		this.qtyMana6 = qtyMana6;
	}

	public Integer getQtyMana7() {
		return qtyMana7;
	}

	public void setQtyMana7(Integer qtyMana7) {
		this.qtyMana7 = qtyMana7;
	}

	public Integer getQtyMana8() {
		return qtyMana8;
	}

	public void setQtyMana8(Integer qtyMana8) {
		this.qtyMana8 = qtyMana8;
	}

	public Integer getQtyMana0() {
		return qtyMana0;
	}

	public void setQtyMana0(Integer qtyMana0) {
		this.qtyMana0 = qtyMana0;
	}

	public BigDecimal getpRed() {
		return pRed;
	}

	public void setpRed(BigDecimal pRed) {
		this.pRed = pRed;
	}

	public BigDecimal getpWhite() {
		return pWhite;
	}

	public void setpWhite(BigDecimal pWhite) {
		this.pWhite = pWhite;
	}

	public BigDecimal getpBlue() {
		return pBlue;
	}

	public void setpBlue(BigDecimal pBlue) {
		this.pBlue = pBlue;
	}

	public BigDecimal getpGreen() {
		return pGreen;
	}

	public void setpGreen(BigDecimal pGreen) {
		this.pGreen = pGreen;
	}

	public BigDecimal getpBlack() {
		return pBlack;
	}

	public void setpBlack(BigDecimal pBlack) {
		this.pBlack = pBlack;
	}

	public BigDecimal getpIncolor() {
		return pIncolor;
	}

	public void setpIncolor(BigDecimal pIncolor) {
		this.pIncolor = pIncolor;
	}

	public boolean getisButtonsDeck() {
		return isButtonsDeck;
	}

	public void setButtonsDeck(boolean isButtonsDeck) {
		this.isButtonsDeck = isButtonsDeck;
	}

	public Integer getQtyOnDeckS() {
		return qtyOnDeckS;
	}

	public void setQtyOnDeckS(Integer qtyOnDeckS) {
		this.qtyOnDeckS = qtyOnDeckS;
	}

	public Integer getQtdA() {
		return qtdA;
	}

	public void setQtdA(Integer qtdA) {
		this.qtdA = qtdA;
	}

	public Integer getQtdC() {
		return qtdC;
	}

	public void setQtdC(Integer qtdC) {
		this.qtdC = qtdC;
	}

	public Integer getQtdE() {
		return qtdE;
	}

	public void setQtdE(Integer qtdE) {
		this.qtdE = qtdE;
	}

	public Integer getQtdT() {
		return qtdT;
	}

	public void setQtdT(Integer qtdT) {
		this.qtdT = qtdT;
	}

	public Integer getQtdF() {
		return qtdF;
	}

	public void setQtdF(Integer qtdF) {
		this.qtdF = qtdF;
	}

	public Integer getQtdM() {
		return qtdM;
	}

	public void setQtdM(Integer qtdM) {
		this.qtdM = qtdM;
	}

	public Integer getQtdP() {
		return qtdP;
	}

	public void setQtdP(Integer qtdP) {
		this.qtdP = qtdP;
	}
}
