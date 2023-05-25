package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;
import theMushrooght.powers.i2WeaknessSporePower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i73Competition extends AbstractDynamicCard {

    public static String ID = theMushrooght.MushrooghtMod.makeID(i73Competition.class.getSimpleName());
    public static String IMG = makeCardPath("i73Competition.png");
    private static CardRarity RARITY = CardRarity.UNCOMMON;
    private static CardTarget TARGET = CardTarget.ALL;
    private static CardType TYPE = CardType.POWER;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;
    private static int COST = 2;
    private static int DEXTERIRY = 2;
    private static int UPGRADE_PLUS_DEXTERIRY = 1;
    private static int WEAKSPORES = 3;
    private static int UPGRADE_PLUS_WEAKSPORES = 1;

    public i73Competition() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i73Competition.png");
        
        magicNumber = baseMagicNumber = DEXTERIRY;
        defaultSecondMagicNumber = defaultBaseSecondMagicNumber = WEAKSPORES;

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