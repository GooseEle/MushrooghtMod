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
import theMushrooght.characters.TheDefault;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i79UtterMastery extends AbstractDynamicCard {


    public static final String ID = theMushrooght.MushrooghtMod.makeID(i79UtterMastery.class.getSimpleName());
    public static final String IMG = makeCardPath("PowerRare.png");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;


    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;

    private static final int COST = 666;
    private static final int UPGRADE_COST = 2;
    private static final int SHARP = 1;
    private static final int UPGRADE_PLUS_SHARP = 1;
    private static final int DEF = 1;

    // /STAT DECLARATION/

    public i79UtterMastery() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = SHARP;
        defaultSecondMagicNumber = defaultBaseSecondMagicNumber = DEF;

        MushrooghtMod.loadJokeCardImage(this, ".png");

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
