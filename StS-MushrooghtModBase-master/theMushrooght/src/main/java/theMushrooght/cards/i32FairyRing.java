package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ObtainPotionAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i32FairyRing extends AbstractDynamicCard {


    public static String ID = theMushrooght.MushrooghtMod.makeID(i32FairyRing.class.getSimpleName());
    public static String IMG = makeCardPath("i32FairyRing.png");

    private static CardRarity RARITY = CardRarity.RARE;
    private static CardTarget TARGET = CardTarget.ALL_ENEMY;
    private static CardType TYPE = CardType.SKILL;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 2;
    private static int UPGRADE_COST = 1;
    private static int POISON = 3;

    // /STAT DECLARATION/

    public i32FairyRing() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i32FairyRing.png");
        
        defaultSecondMagicNumber = defaultBaseSecondMagicNumber = POISON;
        this.exhaust = true;
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ObtainPotionAction(AbstractDungeon.returnRandomPotion(true)));
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            flash();
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    addToBot(new ApplyPowerAction(monster, p, new PoisonPower(monster, p, this.defaultSecondMagicNumber), this.defaultSecondMagicNumber));
                }
            }
        }
    }


    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            upgradeBaseCost(UPGRADE_COST);
            this.initializeDescription();
        }
    }
}