package ws.models;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CardServiceImpl implements CardService {

	private boolean hasColor = false;
	private boolean hasCost = false;
	private boolean hasRarity = false;
	private boolean hasType = false;
	private boolean hasName = false;
	
	public CardList pagging(String url)
	{
		return doRequest(url);
	}
	
	public CardList search(String name, boolean isWhite, boolean isBlue, boolean isBlack, boolean isRed,
			boolean isGreen, boolean isIncolor, boolean isZero, boolean isOne, boolean isTwo, boolean isThree,
			boolean isFour, boolean isFive, boolean isSix, boolean isSeven, boolean isMore, boolean isCommon,
			boolean isUnCommon, boolean isRare, boolean isMitic, boolean isArtifact, boolean isCreature,
			boolean isEnchant, boolean isPlanesWalker, boolean isGround, boolean isInstantMagic, boolean isSpell) {

		String url = getUrl(name, isWhite, isBlue, isBlack, isRed, isGreen, isIncolor, isZero, isOne, isTwo, isThree,
				isFour, isFive, isSix, isSeven, isMore, isCommon, isUnCommon, isRare, isMitic, isArtifact, isCreature,
				isEnchant, isPlanesWalker, isGround, isInstantMagic, isSpell);

		return doRequest(url);
	}

	private CardList doRequest(String url) {
		
		OkHttpClient client = new OkHttpClient.Builder().writeTimeout(1, TimeUnit.MINUTES)
				.readTimeout(1, TimeUnit.MINUTES).build();
		Request request = new Request.Builder().url(url).get().addHeader("cache-control", "no-cache").build();
		CardList cardsFound = null;
		Response response = null;
		try {
			response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				cardsFound = new Gson().fromJson(response.body().string(), CardList.class);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			response.close();
		}

		return cardsFound;
	}
	
	private String getUrl(String name, boolean isWhite, boolean isBlue, boolean isBlack, boolean isRed, boolean isGreen,
			boolean isIncolor, boolean isZero, boolean isOne, boolean isTwo, boolean isThree, boolean isFour,
			boolean isFive, boolean isSix, boolean isSeven, boolean isMore, boolean isCommon, boolean isUnCommon,
			boolean isRare, boolean isMitic, boolean isArtifact, boolean isCreature, boolean isEnchant,
			boolean isPlanesWalker, boolean isGround, boolean isInstantMagic, boolean isSpell) {
		
		StringBuilder url = new StringBuilder("https://api.scryfall.com/cards/search?format=json&q=");

		hasName = false;
		if(name != null && !name.isEmpty())
		{
			name = name.replace(" ", "+");
			url.append("name%3D").append(name);
			hasName = true;
		}
		
		if(hasName)
			url.append("+");
		
		// Start color
		hasColor = false;
		if (isWhite || isBlue || isBlack || isRed || isGreen || isIncolor) {
			hasColor = true;
			url.append("c%3D");
		}
		if (isWhite) {
			url.append("w");
		}
		if (isBlue) {
			url.append("u");
		}
		if (isBlack) {
			url.append("b");
		}
		if (isRed) {
			url.append("r");
		}
		if (isGreen) {
			url.append("g");
		}
		if (isIncolor) {
			url.append("c");
		}

		if (hasColor)
			url.append("+");
		// End Color

		// Start Cost
		hasCost = false;
		url.append("%28");
		if (isZero) {
			url.append("cmc%3D0");
			hasCost = true;
		}
		if (isOne) {
			if (hasCost)
				url.append("+or+");
			url.append("cmc%3D1");
			hasCost = true;
		}
		if (isTwo) {
			if (hasCost)
				url.append("+or+");
			url.append("cmc%3D2");
			hasCost = true;
		}
		if (isThree) {
			if (hasCost)
				url.append("+or+");
			url.append("cmc%3D3");
			hasCost = true;
		}
		if (isFour) {
			if (hasCost)
				url.append("+or+");
			url.append("cmc%3D4");
			hasCost = true;
		}
		if (isFive) {
			if (hasCost)
				url.append("+or+");
			url.append("cmc%3D5");
			hasCost = true;
		}
		if (isSix) {
			if (hasCost)
				url.append("+or+");
			url.append("cmc%3D6");
			hasCost = true;
		}
		if (isSeven) {
			if (hasCost)
				url.append("+or+");
			url.append("cmc%3D7");
			hasCost = true;
		}
		if (isMore) {
			if (hasCost)
				url.append("+or+");
			url.append("cmc>7");
			hasCost = true;
		}
		url.append("%29");
		if (hasCost)
			url.append("+");
		// End Cost

		// Start rarity
		hasRarity = false;
		url.append("%28");
		if (isCommon) {
			url.append("r%3Dc");
			hasRarity = true;
		}
		if (isUnCommon) {
			if (hasRarity)
				url.append("+or+");
			url.append("r%3Du");
			hasRarity = true;
		}
		if (isRare) {
			if (hasRarity)
				url.append("+or+");
			url.append("r%3Dr");
			hasRarity = true;
		}
		if (isMitic) {
			if (hasRarity)
				url.append("+or+");
			url.append("r%3Dm");
			hasRarity = true;
		}
		url.append("%29");
		if (hasRarity)
			url.append("+");
		// End rarity

		// Start Type
		hasType = false;
		url.append("%28");
		if (isArtifact) {
			url.append("t%3Aartifact");
			hasType = true;
		}
		if (isCreature) {
			if (hasType)
				url.append("+or+");
			url.append("t%3Acreature");
			hasType = true;
		}
		if (isEnchant) {
			if (hasType)
				url.append("+or+");
			url.append("t%3Aenchantment");
			hasType = true;
		}
		if (isPlanesWalker) {
			if (hasType)
				url.append("+or+");
			url.append("t%3Aplaneswalker");
			hasType = true;
		}
		if (isGround) {
			if (hasType)
				url.append("+or+");
			url.append("t%3Aland");
			hasType = true;
		}
		if (isInstantMagic) {
			if (hasType)
				url.append("+or+");
			url.append("t%3Ainstant");
			hasType = true;
		}
		if (isSpell) {
			if (hasType)
				url.append("+or+");
			url.append("t%3Asorcery");
			hasType = true;
		}
		url.append("%29");
		// End Type
		url.append("&unique=cards&order=name");

		return url.toString();

	}

}
