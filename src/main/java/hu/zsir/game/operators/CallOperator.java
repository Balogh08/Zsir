/* 
 * Copyright (C) 2015 Feco
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package hu.zsir.game.operators;

import hu.zsir.game.model.Card;
import hu.zsir.game.model.Game;
import hu.zsir.game.model.Number;
import hu.zsir.game.model.Player;

/**
 *
 * @author Feco
 */
public class CallOperator implements Operator {
    
    private static CallOperator calloperator = new CallOperator();
    
    private CallOperator() {
    }
    
    @Override
    public boolean isApplicable(Game game) {
        return (!game.getCurrentplayer().cards.isEmpty()) && !game.getNextplayer().isChecked()
                && !BeatOperator.getBeatoperator().isApplicable(game)
                && (game.getTable().getCards().isEmpty() || game.getTable().getCards().size() % 2 == 1
                || canCall(game.getCurrentplayer(), game.getTable().getCards().get(0)));
    }
    
    @Override
    public void apply(Game game) {
        Card card = game.getCurrentplayer().putCard();
        card.turnUp();
        game.getTable().addCard(card);
        game.getCurrentplayer().setChoosedCard(null);
        game.swapPlayers();
    }
    
    private boolean canCall(Player currentplayer, Card firstcard) {
        for (Card card : currentplayer.cards) {
            if (card.getNumber() == firstcard.getNumber() || card.getNumber() == Number.HET) {
                return true;
            }
        }
        return false;
    }
    
    public static CallOperator getCallOperator() {
        return calloperator;
    }    
    
}
