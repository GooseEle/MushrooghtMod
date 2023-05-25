package theMushrooght.cards;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.curses.Parasite;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.HemokinesisEffect;
import com.megacrit.cardcrawl.vfx.combat.VerticalAuraEffect;
import theMushrooght.MushrooghtMod;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.player;
import static theMushrooght.MushrooghtMod.makeCardPath;

public class i83MushroomGrowth20 extends AbstractGrowthCard {



    public static final String ID = theMushrooght.MushrooghtMod.makeID(i83MushroomGrowth20.class.getSimpleName());
    public static final String IMG = makeCardPath("i83MushroomGrowth20.png");

    private static final CardRarity RARITY = CardRarity.CURSE;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.CURSE;

    public static final CardColor COLOR = AbstractCard.CardColor.CURSE;
    private static final int COST = -2;



    public void use(AbstractPlayer p, AbstractMonster m) {}

    public i83MushroomGrowth20() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        this.selfRetain = true;
        this.cardsToPreview = new Parasite();
        MushrooghtMod.loadJokeCardImage(this, "i83MushroomGrowth20.png");
    }

    public void triggerOnExhaust() {
            addToBot(new VFXAction(player, new VerticalAuraEffect(Color.FIREBRICK, player.hb.cX, player.hb.cY), 0.0F));
        addToBot(new MakeTempCardInDiscardAction(new Parasite(), 1));
        addToBot(new VFXAction(new HemokinesisEffect(player.hb.cX, player.hb.cY, player.hb.cX, player.hb.cY), 0.5F));
    }


    @Override
    public void upgrade() {}

    public AbstractCard makeCopy() {
        return new i83MushroomGrowth20();
    }
}
