package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.actions.i6UnsafeBlockAction;
import theMushrooght.characters.TheDefault;
import theMushrooght.powers.i3UnsafeBlockPower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i10Consumedmind extends AbstractDynamicCard {



    public static final String ID = theMushrooght.MushrooghtMod.makeID(i10Consumedmind.class.getSimpleName());
    public static final String IMG = makeCardPath("i10Consumedmind.png");


    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;

    private static final int COST = 1;
    private static final int BAD_BLOCK = 12;
    private static final int UPGRADE_PLUS_BAD_BLOCK = 4;


    public i10Consumedmind() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = BAD_BLOCK;
        this.isEthereal = true;
        MushrooghtMod.loadJokeCardImage(this, "i10Consumedmind.png");
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new i6UnsafeBlockAction(p));
        AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(p, p, new i3UnsafeBlockPower(p, magicNumber), magicNumber));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_BAD_BLOCK);
            initializeDescription();
        }
    }
}
