package com.aura.organizationapi.domain.model.setting;

public record UserSettings(Global global, Organization organization) {

    public record Global(Theme theme) {
        public enum Theme {
            WHITE, //padrão
            DARK
        }
    }

    public record Organization(Tree tree, SubPossitionStrategy subPossitionStrategy) {
        public enum Tree {
            FULLY_CLOSED,
            FULLY_OPEN,
            OPEN_ONE_LEVEL_DEPTH,
            OPEN_TWO_LEVEL_DEPTH,
            OPEN_THREE_LEVEL_DEPTH,
            OPEN_JUST_MY_DEPTH, //Abrir a árvore apenas no caminho do usuário
        }

        public enum SubPossitionStrategy {
            SEQUENCE,
            LEVEL
        }
    }

    public record Ticket() {

    }

}
