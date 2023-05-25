package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheDefault;
import theMushrooght.powers.i2WeaknessSporePower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i8Propagation extends AbstractDynamicCard {


    public static final String ID = theMushrooght.MushrooghtMod.makeID(i8Propagation.class.getSimpleName());
    public static final String IMG = makeCardPath("i8Propagation.png");


    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;
    private static final int COST = 1;
    private static final int UPGRADE_COST = 0;
    private static final int SPORES = 2;
    private static final int UPGRADE_PLUS_SPORES = 1;

    // /STAT DECLARATION/
    public i8Propagation() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = SPORES;
        MushrooghtMod.loadJokeCardImage(this, "i8Propagation.png");
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            flash();
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    addToBot(new ApplyPowerAction(monster, p, new i2WeaknessSporePower(monster, magicNumber), magicNumber));
                }
            }
        }
    }
    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_SPORES);
            upgradeBaseCost(UPGRADE_COST);
            this.initializeDescription();
        }
    }
}
