package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AfterImagePower;
import com.megacrit.cardcrawl.powers.ThousandCutsPower;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i79UtterMastery extends AbstractDynamicCard {


    public static String ID = theMushrooght.MushrooghtMod.makeID(i79UtterMastery.class.getSimpleName());
    public static String IMG = makeCardPath("i79UtterMastery.png");
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;


    private static CardRarity RARITY = CardRarity.RARE;
    private static CardTarget TARGET = CardTarget.SELF;
    private static CardType TYPE = CardType.POWER;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 666;
    private static int UPGRADE_COST = 2;
    private static int SHARP = 1;
    private static int UPGRADE_PLUS_SHARP = 1;
    private static int DEF = 1;

    // /STAT DECLARATION/

    public i79UtterMastery() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        if (!this.upgraded) {
            MushrooghtMod.loadJokeCardImage(this, "i79UtterMasteryNoUpg.png");
        }
        if (this.upgraded) {
            MushrooghtMod.loadJokeCardImage(this, "i79UtterMasteryUpg.png");
        }

        magicNumber = baseMagicNumber = SHARP;
        defaultSecondMagicNumber = defaultBaseSecondMagicNumber = DEF;


    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new ThousandCutsPower(p, this.magicNumber), this.magicNumber));
        addToBot(new ApplyPowerAction(p, p, new AfterImagePower(p, this.defaultSecondMagicNumber), this.defaultSecondMagicNumber));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.isInnate = true;
            this.upgradeMagicNumber(UPGRADE_PLUS_SHARP);
            upgradeBaseCost(UPGRADE_COST);
            this.initializeDescription();
            rawDescription = UPGRADE_DESCRIPTION;

        }
    }

    public AbstractCard makeCopy() {
        return new i79UtterMastery();
    }
}
