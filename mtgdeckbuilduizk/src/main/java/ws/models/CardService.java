package ws.models;

import java.util.List;

public interface CardService {

	public List<Datum> search(String name, boolean isWhite, boolean isBlue, boolean isBlack, boolean isRed,
			boolean isGreen, boolean isIncolor, boolean isZero, boolean isOne, boolean isTwo, boolean isThree,
			boolean isFour, boolean isFive, boolean isSix, boolean isSeven, boolean isMore, boolean isCommon,
			boolean isUnCommon, boolean isRare, boolean isMitic, boolean isArtifact, boolean isCreature,
			boolean isEnchant, boolean isPlanesWalker, boolean isGround, boolean isInstantMagic, boolean isSpell);

}
