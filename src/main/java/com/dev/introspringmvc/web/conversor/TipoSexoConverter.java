package com.dev.introspringmvc.web.conversor;

import com.dev.introspringmvc.domain.TipoSexo;
import org.springframework.core.convert.converter.Converter;

public class TipoSexoConverter implements Converter<String, TipoSexo> {

    @Override
    public TipoSexo convert(String text) {
        char tipo = text.charAt(0);
        return tipo == TipoSexo.FEMININO.getDesc() ? TipoSexo.FEMININO : TipoSexo.MASCULINO ;
    }

}
