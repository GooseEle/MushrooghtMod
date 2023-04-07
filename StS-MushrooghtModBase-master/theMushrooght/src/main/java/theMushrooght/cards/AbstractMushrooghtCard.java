package theMushrooght.cards;

import basemod.abstracts.CustomCard;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import theMushrooght.util.TextureLoader;

public abstract class AbstractMushrooghtCard extends CustomCard {
    public String betaArtPath;

    public String DESCRIPTION;

    public String UPGRADE_DESCRIPTION;

    public String NAME;

    public CardStrings cardStrings;
    public String[] EXTENDED_DESCRIPTION;

    public int defaultSecondMagicNumber;

    public int defaultBaseSecondMagicNumber;
    public boolean upgradedDefaultSecondMagicNumber;
    public boolean isDefaultSecondMagicNumberModified;
    public AbstractMushrooghtCard(String id, String name, String img, int cost, String rawDescription, AbstractCard.CardType type, AbstractCard.CardColor color, AbstractCard.CardRarity rarity, AbstractCard.CardTarget target) {
        super(id, name, img, cost, rawDescription, type, color, rarity, target);
        this.isCostModified = false;
        this.isCostModifiedForTurn = false;
        this.isDamageModified = false;
        this.isBlockModified = false;
        this.isMagicNumberModified = false;
        this.isDefaultSecondMagicNumberModified = false;
    }

    public void displayUpgrades() {
        super.displayUpgrades();
        if (this.upgradedDefaultSecondMagicNumber) {
            this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber;
            this.isDefaultSecondMagicNumberModified = true;
        }
    }
    public void upgradeDefaultSecondMagicNumber(int amount) {
        this.defaultBaseSecondMagicNumber += amount;
        this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber;
        this.upgradedDefaultSecondMagicNumber = true;
    }
    protected Texture getPortraitImage() {
        if (Settings.PLAYTESTER_ART_MODE || UnlockTracker.betaCardPref.getBoolean(this.cardID, false)) {
            if (this.textureImg == null)
                return null;
            if (this.betaArtPath != null) {
                int endingIndex = this.betaArtPath.lastIndexOf(".");
                String newPath = this.betaArtPath.substring(0, endingIndex) + "_p" + this.betaArtPath.substring(endingIndex);
                newPath = "theMushrooghtResources/images/betacards/" + newPath;
                System.out.println("Finding texture: " + newPath);
                Texture portraitTexture = TextureLoader.getTexture(newPath);
                return portraitTexture;
            }
        }
        return super.getPortraitImage();
    }



}
