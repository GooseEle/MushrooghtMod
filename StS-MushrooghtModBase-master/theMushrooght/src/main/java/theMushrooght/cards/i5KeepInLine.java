package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheDefault;
import theMushrooght.powers.i6MyceliumPower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i5KeepInLine extends AbstractDynamicCard {



    public static final String ID = theMushrooght.MushrooghtMod.makeID(i5KeepInLine.class.getSimpleName());
    public static final String IMG = makeCardPath("i5KeepInLine.png");



    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;

    private static final int COST = 0;
    private static final int BLOCK = 3;
    private static final int MYCELIUM = 1;
    private static final int UPGRADE_PLUS_MYCELIUM = 2;





    public i5KeepInLine() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        baseBlock = BLOCK;
        magicNumber = baseMagicNumber = MYCELIUM;
        this.exhaust = true;
        MushrooghtMod.loadJokeCardImage(this, "i5KeepInLine.png");
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, block));
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new i6MyceliumPower(p, p, this.magicNumber), this.magicNumber));
    }


    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(UPGRADE_PLUS_MYCELIUM);
            initializeDescription();
        }
    }
}