package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.actions.i6UnsafeBlockAction;
import theMushrooght.characters.TheMushrooght;
import theMushrooght.powers.i3UnsafeBlockPower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i16Reflexion extends AbstractDynamicCard {



    public static String ID = theMushrooght.MushrooghtMod.makeID(i16Reflexion.class.getSimpleName());
    public static String IMG = makeCardPath("i16Reflexion.png");


    private static CardRarity RARITY = CardRarity.COMMON;
    private static CardTarget TARGET = CardTarget.SELF;
    private static CardType TYPE = CardType.SKILL;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 1;
    private static int BAD_BLOCK = 6;
    private static int UPGRADE_PLUS_BAD_BLOCK = 4;
    private static int CARD = 1;
    private static int UPGRADE_PLUS_CARD = 1;


    public i16Reflexion() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "");
        
        magicNumber = baseMagicNumber = BAD_BLOCK;
        defaultSecondMagicNumber = defaultBaseSecondMagicNumber = CARD;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new i6UnsafeBlockAction(p));
        AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(p, p, new i3UnsafeBlockPower(p, magicNumber), magicNumber));

        addToBot(new DrawCardAction(p, this.defaultSecondMagicNumber));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_BAD_BLOCK);
            this.upgradeDefaultSecondMagicNumber(UPGRADE_PLUS_CARD);
            initializeDescription();
        }
    }
}
