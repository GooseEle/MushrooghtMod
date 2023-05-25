package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.unique.DoublePoisonAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i24Curselyst extends AbstractDynamicCard {



    public static String ID = theMushrooght.MushrooghtMod.makeID(i24Curselyst.class.getSimpleName());
    public static String IMG = makeCardPath("i24Curselyst.png");
    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    private static CardRarity RARITY = CardRarity.UNCOMMON;
    private static CardTarget TARGET = CardTarget.ENEMY;
    private static CardType TYPE = CardType.SKILL;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 1;


    // /STAT DECLARATION/


    public i24Curselyst() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i24Curselyst.png");
        
        this.exhaust = true;
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
            addToBot(new DoublePoisonAction(m, p));
        if (this.upgraded) {
        addToBot(new ExhaustAction(2, false, true, true));
         } else {
            addToBot(new ExhaustAction(2, false, false, false));
        }
}


    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }
}