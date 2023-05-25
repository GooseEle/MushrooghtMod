package theMushrooght.cards;

import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i6MushroomGrowth1 extends AbstractGrowthCard {



    public static String ID = theMushrooght.MushrooghtMod.makeID(i6MushroomGrowth1.class.getSimpleName());
    public static String IMG = makeCardPath("i6MushroomGrowth1.png");

    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    private static CardRarity RARITY = CardRarity.COMMON;
    private static CardTarget TARGET = CardTarget.SELF;
    private static CardType TYPE = CardType.SKILL;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 1;

    private static int BLOCK = 8;

    private static int UPGRADE_PLUS_BLOCK = 6;


    // /STAT DECLARATION/


    public i6MushroomGrowth1() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i6MushroomGrowth1.png");
        
        baseBlock = BLOCK;
        this.exhaust = true;
        
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, this.block));

        AbstractCard c = AbstractGrowthCard.returnRandomGrowth();
        CardModifierManager.addModifier(c, new EtherealMod());
        addToBot(new MakeTempCardInHandAction(c, true));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeBlock(UPGRADE_PLUS_BLOCK);
            initializeDescription();
        }
    }
}