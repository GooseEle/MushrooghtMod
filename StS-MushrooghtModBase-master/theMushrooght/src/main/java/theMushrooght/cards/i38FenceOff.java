package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theMushrooght.MushrooghtMod;
import theMushrooght.characters.TheMushrooght;
import theMushrooght.powers.i6MyceliumPower;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.player;
import static theMushrooght.MushrooghtMod.makeCardPath;
public class i38FenceOff extends AbstractDynamicCard {

    public static String ID = theMushrooght.MushrooghtMod.makeID(i38FenceOff.class.getSimpleName());
    public static String IMG = makeCardPath("i38FenceOff.png");
    private static CardRarity RARITY = CardRarity.RARE;
    private static CardTarget TARGET = CardTarget.NONE;
    private static CardType TYPE = CardType.SKILL;
    public static CardColor COLOR = TheMushrooght.Enums.COLOR_MUSHROOM;
    private static int COST = -2;
    private static int MYCELIUM = 5;
    private static int UPGRADE_PLUS_MYCELIUM = 2;

    public i38FenceOff() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        MushrooghtMod.loadJokeCardImage(this, "i38FenceOff.png");
        
        magicNumber = baseMagicNumber = MYCELIUM;
    }

    public void triggerWhenDrawn() {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(player, player, new i6MyceliumPower(player, player, magicNumber), magicNumber));
        addToBot(new DrawCardAction(player, 1));
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {}
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {return false;}


    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            initializeDescription();
            this.upgradeMagicNumber(UPGRADE_PLUS_MYCELIUM);
        }
    }
}
