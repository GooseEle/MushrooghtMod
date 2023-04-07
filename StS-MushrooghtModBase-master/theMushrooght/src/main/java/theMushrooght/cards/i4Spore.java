package theMushrooght.cards;

import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheDefault;
import theMushrooght.powers.i6MyceliumPower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i4Spore extends AbstractDynamicCard {


    public static final String ID = theMushrooght.MushrooghtMod.makeID(i4Spore.class.getSimpleName());
    public static final String IMG = makeCardPath("i4Spore.png");


    private static final CardRarity RARITY = CardRarity.BASIC;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;

    private static final int COST = 2;
    private static final int MYCELIUM = 3;
    private static final int UPGRADE_PLUS_MYCELIUM = 3;

    // /STAT DECLARATION/

    public i4Spore() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);

        magicNumber = baseMagicNumber = MYCELIUM;
        MushrooghtMod.loadJokeCardImage(this, "i4Spore.png");
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new i6MyceliumPower(p, p, this.magicNumber), this.magicNumber));



        AbstractCard c = AbstractGrowthCard.returnRandomGrowth();
        CardModifierManager.addModifier(c, new EtherealMod());
        addToBot(new MakeTempCardInHandAction(c, true));
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_MYCELIUM);
            this.initializeDescription();
        }
    }
}