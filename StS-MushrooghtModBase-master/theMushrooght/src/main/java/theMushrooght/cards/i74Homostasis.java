package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheDefault;
import theMushrooght.powers.i1SporePower;
import theMushrooght.powers.i6MyceliumPower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i74Homostasis extends AbstractDynamicCard {

    public static final String ID = theMushrooght.MushrooghtMod.makeID(i74Homostasis.class.getSimpleName());
    public static final String IMG = makeCardPath("PowerUncommon.png");
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ALL;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;
    private static final int COST = 2;
    private static final int MYCO = 6;
    private static final int UPGRADE_PLUS_MYCO = 3;

    public i74Homostasis() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = MYCO;
        MushrooghtMod.loadJokeCardImage(this, ".png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new HealAction(p, p, 6));
        addToBot(new ApplyPowerAction(p, p, new i6MyceliumPower(p, p, magicNumber), magicNumber));

        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            flash();
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    addToBot(new ApplyPowerAction(m, p, new i1SporePower(m, 2), 2));
                }
            }
        }
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_MYCO);
            initializeDescription();
        }
    }
}
