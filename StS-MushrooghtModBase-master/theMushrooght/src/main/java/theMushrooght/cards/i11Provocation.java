package theMushrooght.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.vfx.combat.ShockWaveEffect;
import theMushrooght.MushrooghtMod;
import theMushrooght.actions.i6UnsafeBlockAction;
import theMushrooght.characters.TheDefault;
import theMushrooght.powers.i3UnsafeBlockPower;

import static theMushrooght.MushrooghtMod.makeCardPath;

public class i11Provocation extends AbstractDynamicCard {



    public static final String ID = theMushrooght.MushrooghtMod.makeID(i11Provocation.class.getSimpleName());
    public static final String IMG = makeCardPath("i11Provocation.png");


    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = TheDefault.Enums.COLOR_MUSHROOM;

    private static final int COST = 1;
    private static final int BAD_BLOCK = 15;
    private static final int UPGRADE_PLUS_BAD_BLOCK = 4;
    private static final int UPGRADE_COST = 0;


    public i11Provocation() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        magicNumber = baseMagicNumber = BAD_BLOCK;
        MushrooghtMod.loadJokeCardImage(this, "i11Provocation.png");
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SFXAction("ATTACK_PIERCING_WAIL"));
        if (Settings.FAST_MODE) {
            addToBot(new VFXAction(p, new ShockWaveEffect(p.hb.cX, p.hb.cY, Settings.GREEN_TEXT_COLOR, ShockWaveEffect.ShockWaveType.CHAOTIC), 0.3F));
        } else {
            addToBot(new VFXAction(p, new ShockWaveEffect(p.hb.cX, p.hb.cY, Settings.GREEN_TEXT_COLOR, ShockWaveEffect.ShockWaveType.CHAOTIC), 1.5F));
        }
        for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters)
            addToBot(new ApplyPowerAction(mo, p, new LoseStrengthPower(mo, 2), 2, true, AbstractGameAction.AttackEffect.NONE));
        for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
            if (!mo.hasPower("Artifact"))
                addToBot(new ApplyPowerAction(mo, p, new StrengthPower(mo, 2), 2, true, AbstractGameAction.AttackEffect.NONE));
        }

        AbstractDungeon.actionManager.addToBottom(new i6UnsafeBlockAction(p));
        AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(p, p, new i3UnsafeBlockPower(p, magicNumber), magicNumber));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_BAD_BLOCK);
            upgradeBaseCost(UPGRADE_COST);
            initializeDescription();
        }
    }
}
