package theMushrooght.cards;

import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i45MushroomGrowth10 extends AbstractGrowthCard {



    public static String ID = theMushrooght.MushrooghtMod.makeID(i45MushroomGrowth10.class.getSimpleName());
    public static String IMG = makeCardPath("AttackCommon.png");

    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;


    private static CardRarity RARITY = CardRarity.COMMON;
    private static CardTarget TARGET = CardTarget.ENEMY;
    private static CardType TYPE = CardType.ATTACK;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 1;
    private static int DAMAGE = 8;
    private static int UPGRADE_PLUS_DMG = 2;
    private static int CARD = 1;
    private static int UPGRADE_PLUS_CARD = 1;



    public i45MushroomGrowth10() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "");
        
        baseDamage = DAMAGE;
        magicNumber = baseMagicNumber = CARD;
        this.exhaust = true;
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
        addToBot(new DrawCardAction(p, this.magicNumber));


        AbstractCard c = AbstractGrowthCard.returnRandomGrowth();
        CardModifierManager.addModifier(c, new EtherealMod());
        addToBot(new MakeTempCardInHandAction(c, true));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(UPGRADE_PLUS_DMG);
            this.upgradeMagicNumber(UPGRADE_PLUS_CARD);
            this.initializeDescription();
            rawDescription = UPGRADE_DESCRIPTION;
        }
    }
}