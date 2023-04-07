package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheDefault;
import theMushrooght.powers.i2WeaknessSporePower;
import theMushrooght.powers.i6MyceliumPower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i69Neutralism extends AbstractDynamicCard {

    public static final String ID = theMushrooght.MushrooghtMod.makeID(i69Neutralism.class.getSimpleName());
    public static final String IMG = makeCardPath("i69Neutralism.png");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ALL;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;
    private static final int COST = 2;

    public i69Neutralism() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i69Neutralism.png");


    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, 1), 1));
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, 1), 1));

        new GainEnergyAction(1);

        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            flash();
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    addToBot(new ApplyPowerAction(m, p, new i2WeaknessSporePower(m, 3), 3));
                }
            }
        }
                    if (!upgraded) {
                        addToBot(new ApplyPowerAction(p, p, new i6MyceliumPower(p, p, 3), 3));
        }
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            this.rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }
}
