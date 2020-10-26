package com.dev.introspringmvc.domain;

import lombok.Getter;

public enum TipoSexo {
    FEMININO('F'), MASCULINO('M');

    @Getter
    private char desc;

    TipoSexo(char desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
