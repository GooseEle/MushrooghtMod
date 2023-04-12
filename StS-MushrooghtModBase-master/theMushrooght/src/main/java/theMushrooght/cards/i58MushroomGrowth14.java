package theMushrooght.cards;

import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.actions.i5AttackPerAttackAction;
import theMushrooght.characters.TheDefault;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i58MushroomGrowth14 extends AbstractGrowthCard {



    public static final String ID = theMushrooght.MushrooghtMod.makeID(i58MushroomGrowth14.class.getSimpleName());
    public static final String IMG = makeCardPath("AttackUncommon.png");

    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;

    private static final int COST = 1;
    private static final int DAMAGE = 4;
    private static final int UPGRADE_PLUS_DMG = 2;



    public i58MushroomGrowth14() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        baseDamage = DAMAGE;
        this.exhaust = true;
        MushrooghtMod.loadJokeCardImage(this, ".png");

    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractCard c = AbstractGrowthCard.returnRandomGrowth();
        CardModifierManager.addModifier(c, new EtherealMod());
        addToBot(new MakeTempCardInHandAction(c, true));



        addToBot(new i5AttackPerAttackAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn)));
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
    }
    public void applyPowers() {
        super.applyPowers();
        int count = 0;
        for (AbstractCard c : AbstractDungeon.player.hand.group) {
            if (c.type == AbstractCard.CardType.ATTACK)
                count++;
        }
        this.rawDescription = cardStrings.DESCRIPTION;
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0] + count;
        if (count == 1) {
            this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[1];
        } else {
            this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[2];
        }
        initializeDescription();
    }

    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(UPGRADE_PLUS_DMG);
        }
    }
}