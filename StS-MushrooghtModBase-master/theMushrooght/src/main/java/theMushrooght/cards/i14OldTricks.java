package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.*;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i14OldTricks extends AbstractDynamicCard {


    public static String ID = theMushrooght.MushrooghtMod.makeID(i14OldTricks.class.getSimpleName());
    public static String IMG = makeCardPath("i14OldTricks.png");


    private static CardRarity RARITY = CardRarity.COMMON;
    private static CardTarget TARGET = CardTarget.SELF;
    private static CardType TYPE = CardType.SKILL;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;
    private static int COST = 1;
    private static int TRICKS = 1;
    private static int UPGRADE_PLUS_TRICKS = 1;

    // /STAT DECLARATION/

    public i14OldTricks() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "");
        
        magicNumber = baseMagicNumber = TRICKS;
        this.cardsToPreview = new i81BizarreParasite();
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new MakeTempCardInHandAction(new i81BizarreParasite(), 1));
        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, this.magicNumber), this.magicNumber));
        addToBot(new ApplyPowerAction(p, p, new LoseStrengthPower(p, this.magicNumber), this.magicNumber));
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, this.magicNumber), this.magicNumber));
        addToBot(new ApplyPowerAction(p, p, new LoseDexterityPower(p, this.magicNumber), this.magicNumber));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_TRICKS);
            this.initializeDescription();
        }
    }
}