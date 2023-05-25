package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheDefault;
import theMushrooght.powers.i2WeaknessSporePower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i73Competition extends AbstractDynamicCard {

    public static final String ID = theMushrooght.MushrooghtMod.makeID(i73Competition.class.getSimpleName());
    public static final String IMG = makeCardPath("PowerUncommon.png");
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ALL;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;
    private static final int COST = 2;
    private static final int DEXTERIRY = 2;
    private static final int UPGRADE_PLUS_DEXTERIRY = 1;
    private static final int WEAKSPORES = 3;
    private static final int UPGRADE_PLUS_WEAKSPORES = 1;

    public i73Competition() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = DEXTERIRY;
        defaultSecondMagicNumber = defaultBaseSecondMagicNumber = WEAKSPORES;
        MushrooghtMod.loadJokeCardImage(this, ".png");

    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, magicNumber), magicNumber));

        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            flash();
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    addToBot(new ApplyPowerAction(m, p, new StrengthPower(m, 1), 1));
                    addToBot(new ApplyPowerAction(m, p, new i2WeaknessSporePower(m, defaultSecondMagicNumber), defaultSecondMagicNumber));
                }
            }
        }
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_DEXTERIRY);
            this.upgradeDefaultSecondMagicNumber(UPGRADE_PLUS_WEAKSPORES);
            initializeDescription();
        }
    }
}