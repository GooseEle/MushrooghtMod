package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.actions.i3PowderyMildewGashAction;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.loadJokeCardImage;
import static theMushrooght.MushrooghtMod.makeCardPath;

public class i42PowderyMildew extends AbstractDynamicCard {


    public static String ID = theMushrooght.MushrooghtMod.makeID(i42PowderyMildew.class.getSimpleName());

    public static String IMG = makeCardPath("i42PowderyMildew.png");




    private static CardRarity RARITY = CardRarity.COMMON;
    private static CardTarget TARGET = CardTarget.ENEMY;
    private static CardType TYPE = CardType.ATTACK;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 0;
    private static int DAMAGE = 1;
    private static int UPGRADE_PLUS_DMG = 1;


    public i42PowderyMildew() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "");
        
        baseDamage = DAMAGE;
        magicNumber = baseMagicNumber = 1;
        loadJokeCardImage(this, "i42PowderyMildew.png");
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
        addToBot(new i3PowderyMildewGashAction(this, this.magicNumber));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(UPGRADE_PLUS_DMG);
            initializeDescription();
        }
    }
}