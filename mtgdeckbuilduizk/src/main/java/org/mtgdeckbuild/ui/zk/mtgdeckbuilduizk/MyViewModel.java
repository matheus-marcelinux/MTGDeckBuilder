package org.mtgdeckbuild.ui.zk.mtgdeckbuilduizk;

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
	private boolean isButtons = false;
	private Integer qtyOnDeck = 0;
	private Integer totalOnDeck = 0;
	private CardService cardService = new CardServiceImpl();

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
	@NotifyChange("qtyOnDeck")
	public void addOne()
	{
		if(selectedCard != null)
		{
			int count = (int)deckList.stream().filter(x -> x.equals(selectedCard)).count();
			if(count < 4)
			{
				deckList.add(selectedCard);
				this.qtyOnDeck = ++count;
			}
			else 
				System.out.println("Apenas 4 cartas");
		}
	}
	
	@Command
	@NotifyChange("qtyOnDeck")
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
		}
	}
	
	@Command
	@NotifyChange("qtyOnDeck")
	public void removeOne()
	{
		if(selectedCard != null && deckList.contains(selectedCard))
		{
			deckList.remove(selectedCard);
			this.qtyOnDeck--;
		}
	}
	
	@Command
	@NotifyChange("qtyOnDeck")
	public void removeAll()
	{
		if(selectedCard != null)
		{			
			while(deckList.contains(selectedCard))
				deckList.remove(selectedCard);
			this.qtyOnDeck = 0;
		}
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

}
