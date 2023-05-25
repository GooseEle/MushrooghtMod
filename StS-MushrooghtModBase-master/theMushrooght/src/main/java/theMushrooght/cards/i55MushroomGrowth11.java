package theMushrooght.cards;

import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.watcher.BlockReturnPower;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i55MushroomGrowth11 extends AbstractGrowthCard {



    public static String ID = theMushrooght.MushrooghtMod.makeID(i55MushroomGrowth11.class.getSimpleName());
    public static String IMG = makeCardPath("AttackUncommon.png");

    private static CardRarity RARITY = CardRarity.UNCOMMON;
    private static CardTarget TARGET = CardTarget.ENEMY;
    private static CardType TYPE = CardType.ATTACK;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 1;
    private static int DAMAGE = 1;
    private static int MAGIC = 1;
    private static int UPGRADE_PLUS_MAGIC = 1;


    public i55MushroomGrowth11() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "");
        
        baseDamage = DAMAGE;
        magicNumber = baseMagicNumber = MAGIC;
        this.exhaust = true;

    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        addToBot(new ApplyPowerAction(m, p, new BlockReturnPower(m, this.magicNumber), this.magicNumber));


        AbstractCard c = AbstractGrowthCard.returnRandomGrowth();
        CardModifierManager.addModifier(c, new EtherealMod());
        addToBot(new MakeTempCardInHandAction(c, true));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(UPGRADE_PLUS_MAGIC);
            initializeDescription();
        }
    }
}
