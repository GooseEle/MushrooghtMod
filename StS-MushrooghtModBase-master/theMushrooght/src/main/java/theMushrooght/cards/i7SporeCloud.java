package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheDefault;
import theMushrooght.powers.i1SporePower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i7SporeCloud extends AbstractDynamicCard {


    public static final String ID = theMushrooght.MushrooghtMod.makeID(i7SporeCloud.class.getSimpleName());
    public static final String IMG = makeCardPath("i7SporeCloud.png");


    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;
    private static final int COST = 1;
    private static final int UPGRADE_COST = 0;
    private static final int SPORES = 2;
    private static final int UPGRADE_PLUS_SPORES = 2;

    // /STAT DECLARATION/
    public i7SporeCloud() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = SPORES;
        MushrooghtMod.loadJokeCardImage(this, "i7SporeCloud.png");
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            flash();
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    addToBot(new ApplyPowerAction(monster, p, new i1SporePower(monster, magicNumber), magicNumber));
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
