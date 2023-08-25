package com.api_calculation.mapper;

import com.api_calculation.client.TankClientRest;
import com.api_calculation.persistence.entity.Liquidacion;
import com.api_calculation.persistence.entity.Tank;
import com.api_calculation.service.dto.LiquidacionInDTO;
import com.api_calculation.util.CalculationsLiq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LiquidacionInDTOToLiquidacion implements IMapper<LiquidacionInDTO, Liquidacion>{



    @Autowired
    private TankClientRest tankClientRest;


    @Override
    public Liquidacion map(LiquidacionInDTO in) {



        Optional<Tank> tank = tankClientRest.findById(in.getIdTank());

        //instancio un objeto de la clase que debo guardar en la base de datos
        Liquidacion liquidacion = new Liquidacion();



        //Instancio un objeto de la clase que me permite hacer los calculos
        CalculationsLiq calculationsLiq = new CalculationsLiq(in.getABD(), in.getGauge(), in.getTov(), in.getWaterGauge(), in.getWaterTov(), tank.get().getFra1(),  tank.get().getFra2(), tank.get().getTempLamina(), in.getTempL(), in.getTAmb(), in.getApi(), in.getWater()+in.getSediment());

        liquidacion.setABD(in.getABD());
        liquidacion.setGauge(in.getGauge());
        liquidacion.setTov(in.getTov());
        liquidacion.setWaterGauge(in.getWaterGauge());
        liquidacion.setWaterTov(in.getWaterTov());
        liquidacion.setKFra1(tank.get().getFra1());
        liquidacion.setKFra2(tank.get().getFra2());
        liquidacion.setTLam(tank.get().getTempLamina());
        liquidacion.setTempL(in.getTempL());
        liquidacion.setTAmb(in.getTAmb());
        liquidacion.setApi60(in.getApi());
        liquidacion.setBsw(in.getWater()+in.getSediment());
        liquidacion.setNombreTk(tank.get().getNombreTk());


        liquidacion.setFra(calculationsLiq.fra());
        liquidacion.setCtsh(calculationsLiq.ctsh());
        liquidacion.setGov(calculationsLiq.gov());
        liquidacion.setCtl(calculationsLiq.ctl());
        liquidacion.setGsv(calculationsLiq.gsv());
        liquidacion.setNsv(calculationsLiq.nsv());


        return liquidacion;

    }


}
