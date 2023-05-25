package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;
import theMushrooght.powers.i6MyceliumPower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i5KeepInLine extends AbstractDynamicCard {



    public static String ID = theMushrooght.MushrooghtMod.makeID(i5KeepInLine.class.getSimpleName());
    public static String IMG = makeCardPath("i5KeepInLine.png");



    private static CardRarity RARITY = CardRarity.COMMON;
    private static CardTarget TARGET = CardTarget.SELF;
    private static CardType TYPE = CardType.SKILL;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;

    private static int COST = 0;
    private static int BLOCK = 3;
    private static int MYCELIUM = 1;
    private static int UPGRADE_PLUS_MYCELIUM = 2;





    public i5KeepInLine() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i5KeepInLine.png");
        
        baseBlock = BLOCK;
        magicNumber = baseMagicNumber = MYCELIUM;
        this.exhaust = true;
        
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