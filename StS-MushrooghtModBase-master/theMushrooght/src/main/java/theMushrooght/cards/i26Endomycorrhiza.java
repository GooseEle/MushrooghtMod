package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i26Endomycorrhiza extends AbstractDynamicCard {


    public static String ID = theMushrooght.MushrooghtMod.makeID(i26Endomycorrhiza.class.getSimpleName());
    public static String IMG = makeCardPath("i27Ectomycorrhiza.png");

    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    private static CardRarity RARITY = CardRarity.UNCOMMON;
    private static CardTarget TARGET = CardTarget.SELF;
    private static CardType TYPE = CardType.SKILL;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 1;
    private static int ENERGY = 2;
    private static int UPGRADE_PLUS_ENERGY = 1;

    // /STAT DECLARATION/

    public i26Endomycorrhiza() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i27Ectomycorrhiza.png");
        
        magicNumber = baseMagicNumber = ENERGY;
        this.exhaust = true;
        this.cardsToPreview = new i81BizarreParasite();
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new MakeTempCardInHandAction(new i81BizarreParasite(), 1));
        addToBot(new GainEnergyAction(this.magicNumber));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_ENERGY);
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }
}