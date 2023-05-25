package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ShuffleAction;
import com.megacrit.cardcrawl.actions.defect.ShuffleAllAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.characters.TheDefault;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i36Stroma extends AbstractDynamicCard {


    public static final String ID = theMushrooght.MushrooghtMod.makeID(i36Stroma.class.getSimpleName());
    public static final String IMG = makeCardPath("SkillRare.png");

    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;

    private static final int COST = 1;
    private static final int UPGRADE_COST = 0;
    private static final int DRAW = 5;
    private static final int UPGRADE_PLUS_DRAW = 1;

    // /STAT DECLARATION/

    public i36Stroma() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = DRAW;

    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ShuffleAllAction());
        addToBot(new ShuffleAction(AbstractDungeon.player.drawPile, false));
        addToBot(new DrawCardAction(p, this.magicNumber));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_DRAW);
            upgradeBaseCost(UPGRADE_COST);
            this.initializeDescription();
        }
    }
}