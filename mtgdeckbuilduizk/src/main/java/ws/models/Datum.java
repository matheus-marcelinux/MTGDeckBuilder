
package ws.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("object")
    @Expose
    private String object;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("oracle_id")
    @Expose
    private String oracleId;
    @SerializedName("multiverse_ids")
    @Expose
    private List<Integer> multiverseIds = null;
    @SerializedName("mtgo_id")
    @Expose
    private Integer mtgoId;
    @SerializedName("arena_id")
    @Expose
    private Integer arenaId;
    @SerializedName("tcgplayer_id")
    @Expose
    private Integer tcgplayerId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("released_at")
    @Expose
    private String releasedAt;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("scryfall_uri")
    @Expose
    private String scryfallUri;
    @SerializedName("layout")
    @Expose
    private String layout;
    @SerializedName("highres_image")
    @Expose
    private Boolean highresImage;
    @SerializedName("image_uris")
    @Expose
    private ImageUris imageUris;
    @SerializedName("mana_cost")
    @Expose
    private String manaCost;
    @SerializedName("cmc")
    @Expose
    private Integer cmc;
    @SerializedName("type_line")
    @Expose
    private String typeLine;
    @SerializedName("oracle_text")
    @Expose
    private String oracleText;
    @SerializedName("power")
    @Expose
    private String power;
    @SerializedName("toughness")
    @Expose
    private String toughness;
    @SerializedName("colors")
    @Expose
    private List<String> colors = null;
    @SerializedName("color_identity")
    @Expose
    private List<String> colorIdentity = null;
    @SerializedName("legalities")
    @Expose
    private Legalities legalities;
    @SerializedName("games")
    @Expose
    private List<String> games = null;
    @SerializedName("reserved")
    @Expose
    private Boolean reserved;
    @SerializedName("foil")
    @Expose
    private Boolean foil;
    @SerializedName("nonfoil")
    @Expose
    private Boolean nonfoil;
    @SerializedName("oversized")
    @Expose
    private Boolean oversized;
    @SerializedName("promo")
    @Expose
    private Boolean promo;
    @SerializedName("reprint")
    @Expose
    private Boolean reprint;
    @SerializedName("variation")
    @Expose
    private Boolean variation;
    @SerializedName("set")
    @Expose
    private String set;
    @SerializedName("set_name")
    @Expose
    private String setName;
    @SerializedName("set_type")
    @Expose
    private String setType;
    @SerializedName("set_uri")
    @Expose
    private String setUri;
    @SerializedName("set_search_uri")
    @Expose
    private String setSearchUri;
    @SerializedName("scryfall_set_uri")
    @Expose
    private String scryfallSetUri;
    @SerializedName("rulings_uri")
    @Expose
    private String rulingsUri;
    @SerializedName("prints_search_uri")
    @Expose
    private String printsSearchUri;
    @SerializedName("collector_number")
    @Expose
    private String collectorNumber;
    @SerializedName("digital")
    @Expose
    private Boolean digital;
    @SerializedName("rarity")
    @Expose
    private String rarity;
    @SerializedName("watermark")
    @Expose
    private String watermark;
    @SerializedName("flavor_text")
    @Expose
    private String flavorText;
    @SerializedName("illustration_id")
    @Expose
    private String illustrationId;
    @SerializedName("card_back_id")
    @Expose
    private String cardBackId;
    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("border_color")
    @Expose
    private String borderColor;
    @SerializedName("frame")
    @Expose
    private String frame;
    @SerializedName("frame_effect")
    @Expose
    private String frameEffect;
    @SerializedName("full_art")
    @Expose
    private Boolean fullArt;
    @SerializedName("textless")
    @Expose
    private Boolean textless;
    @SerializedName("booster")
    @Expose
    private Boolean booster;
    @SerializedName("story_spotlight")
    @Expose
    private Boolean storySpotlight;
    @SerializedName("edhrec_rank")
    @Expose
    private Integer edhrecRank;
    @SerializedName("prices")
    @Expose
    private Prices prices;
    @SerializedName("related_uris")
    @Expose
    private RelatedUris relatedUris;
    @SerializedName("purchase_uris")
    @Expose
    private PurchaseUris purchaseUris;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOracleId() {
        return oracleId;
    }

    public void setOracleId(String oracleId) {
        this.oracleId = oracleId;
    }

    public List<Integer> getMultiverseIds() {
        return multiverseIds;
    }

    public void setMultiverseIds(List<Integer> multiverseIds) {
        this.multiverseIds = multiverseIds;
    }

    public Integer getMtgoId() {
        return mtgoId;
    }

    public void setMtgoId(Integer mtgoId) {
        this.mtgoId = mtgoId;
    }

    public Integer getArenaId() {
        return arenaId;
    }

    public void setArenaId(Integer arenaId) {
        this.arenaId = arenaId;
    }

    public Integer getTcgplayerId() {
        return tcgplayerId;
    }

    public void setTcgplayerId(Integer tcgplayerId) {
        this.tcgplayerId = tcgplayerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(String releasedAt) {
        this.releasedAt = releasedAt;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getScryfallUri() {
        return scryfallUri;
    }

    public void setScryfallUri(String scryfallUri) {
        this.scryfallUri = scryfallUri;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public Boolean getHighresImage() {
        return highresImage;
    }

    public void setHighresImage(Boolean highresImage) {
        this.highresImage = highresImage;
    }

    public ImageUris getImageUris() {
        return imageUris;
    }

    public void setImageUris(ImageUris imageUris) {
        this.imageUris = imageUris;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public Integer getCmc() {
        return cmc;
    }

    public void setCmc(Integer cmc) {
        this.cmc = cmc;
    }

    public String getTypeLine() {
        return typeLine;
    }

    public void setTypeLine(String typeLine) {
        this.typeLine = typeLine;
    }

    public String getOracleText() {
        return oracleText;
    }

    public void setOracleText(String oracleText) {
        this.oracleText = oracleText;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getColorIdentity() {
        return colorIdentity;
    }

    public void setColorIdentity(List<String> colorIdentity) {
        this.colorIdentity = colorIdentity;
    }

    public Legalities getLegalities() {
        return legalities;
    }

    public void setLegalities(Legalities legalities) {
        this.legalities = legalities;
    }

    public List<String> getGames() {
        return games;
    }

    public void setGames(List<String> games) {
        this.games = games;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public Boolean getFoil() {
        return foil;
    }

    public void setFoil(Boolean foil) {
        this.foil = foil;
    }

    public Boolean getNonfoil() {
        return nonfoil;
    }

    public void setNonfoil(Boolean nonfoil) {
        this.nonfoil = nonfoil;
    }

    public Boolean getOversized() {
        return oversized;
    }

    public void setOversized(Boolean oversized) {
        this.oversized = oversized;
    }

    public Boolean getPromo() {
        return promo;
    }

    public void setPromo(Boolean promo) {
        this.promo = promo;
    }

    public Boolean getReprint() {
        return reprint;
    }

    public void setReprint(Boolean reprint) {
        this.reprint = reprint;
    }

    public Boolean getVariation() {
        return variation;
    }

    public void setVariation(Boolean variation) {
        this.variation = variation;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getSetType() {
        return setType;
    }

    public void setSetType(String setType) {
        this.setType = setType;
    }

    public String getSetUri() {
        return setUri;
    }

    public void setSetUri(String setUri) {
        this.setUri = setUri;
    }

    public String getSetSearchUri() {
        return setSearchUri;
    }

    public void setSetSearchUri(String setSearchUri) {
        this.setSearchUri = setSearchUri;
    }

    public String getScryfallSetUri() {
        return scryfallSetUri;
    }

    public void setScryfallSetUri(String scryfallSetUri) {
        this.scryfallSetUri = scryfallSetUri;
    }

    public String getRulingsUri() {
        return rulingsUri;
    }

    public void setRulingsUri(String rulingsUri) {
        this.rulingsUri = rulingsUri;
    }

    public String getPrintsSearchUri() {
        return printsSearchUri;
    }

    public void setPrintsSearchUri(String printsSearchUri) {
        this.printsSearchUri = printsSearchUri;
    }

    public String getCollectorNumber() {
        return collectorNumber;
    }

    public void setCollectorNumber(String collectorNumber) {
        this.collectorNumber = collectorNumber;
    }

    public Boolean getDigital() {
        return digital;
    }

    public void setDigital(Boolean digital) {
        this.digital = digital;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getWatermark() {
        return watermark;
    }

    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public String getIllustrationId() {
        return illustrationId;
    }

    public void setIllustrationId(String illustrationId) {
        this.illustrationId = illustrationId;
    }

    public String getCardBackId() {
        return cardBackId;
    }

    public void setCardBackId(String cardBackId) {
        this.cardBackId = cardBackId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getFrameEffect() {
        return frameEffect;
    }

    public void setFrameEffect(String frameEffect) {
        this.frameEffect = frameEffect;
    }

    public Boolean getFullArt() {
        return fullArt;
    }

    public void setFullArt(Boolean fullArt) {
        this.fullArt = fullArt;
    }

    public Boolean getTextless() {
        return textless;
    }

    public void setTextless(Boolean textless) {
        this.textless = textless;
    }

    public Boolean getBooster() {
        return booster;
    }

    public void setBooster(Boolean booster) {
        this.booster = booster;
    }

    public Boolean getStorySpotlight() {
        return storySpotlight;
    }

    public void setStorySpotlight(Boolean storySpotlight) {
        this.storySpotlight = storySpotlight;
    }

    public Integer getEdhrecRank() {
        return edhrecRank;
    }

    public void setEdhrecRank(Integer edhrecRank) {
        this.edhrecRank = edhrecRank;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public RelatedUris getRelatedUris() {
        return relatedUris;
    }

    public void setRelatedUris(RelatedUris relatedUris) {
        this.relatedUris = relatedUris;
    }

    public PurchaseUris getPurchaseUris() {
        return purchaseUris;
    }

    public void setPurchaseUris(PurchaseUris purchaseUris) {
        this.purchaseUris = purchaseUris;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Datum other = (Datum) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

