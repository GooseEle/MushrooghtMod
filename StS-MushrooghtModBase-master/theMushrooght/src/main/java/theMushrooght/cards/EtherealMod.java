package theMushrooght.cards;

import basemod.abstracts.AbstractCardModifier;
import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import theMushrooght.MushrooghtMod;

public class EtherealMod extends AbstractCardModifier {
    public static final String ID = theMushrooght.MushrooghtMod.makeID(EtherealMod.class.getSimpleName());

    public String modifyDescription(String rawDescription, AbstractCard card) {
        if (!card.selfRetain) {
            return (CardCrawlGame.languagePack.getUIString(MushrooghtMod.makeID("EtherealMod"))).TEXT[0] + rawDescription;
        }
        return rawDescription;
    }

    public boolean shouldApply(AbstractCard card) {
        return !CardModifierManager.hasModifier(card, ID);
    }

    public void onInitialApplication(AbstractCard card) {
        card.isEthereal = true;
    }

    public AbstractCardModifier makeCopy() {
        return new EtherealMod();
    }

    public String identifier(AbstractCard card) {
        return ID;
    }
}
