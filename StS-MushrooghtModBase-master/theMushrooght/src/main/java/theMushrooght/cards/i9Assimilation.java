package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheDefault;
import theMushrooght.powers.i1SporePower;
import theMushrooght.powers.i2WeaknessSporePower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i9Assimilation extends AbstractDynamicCard {

    public static final String ID = theMushrooght.MushrooghtMod.makeID(i9Assimilation.class.getSimpleName());
    public static final String IMG = makeCardPath("i9Assimilation.png");
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;
    private static final int COST = 0;
    private static final int SPORES = 2;
    private static final int UPGRADE_PLUS_SPORES = 2;
    private static final int WEAKSPORES = 2;
    private static final int UPGRADE_PLUS_WEAKSPORES = 1;

    // /STAT DECLARATION/
    public i9Assimilation() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = SPORES;
        defaultSecondMagicNumber = defaultBaseSecondMagicNumber = WEAKSPORES;
        this.exhaust = true;
        MushrooghtMod.loadJokeCardImage(this, "i9Assimilation.png");
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            flash();
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    addToBot(new ApplyPowerAction(monster, p, new i2WeaknessSporePower(monster, defaultSecondMagicNumber), defaultSecondMagicNumber));
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
            this.upgradeDefaultSecondMagicNumber(UPGRADE_PLUS_WEAKSPORES);
            this.initializeDescription();
        }
    }
}
