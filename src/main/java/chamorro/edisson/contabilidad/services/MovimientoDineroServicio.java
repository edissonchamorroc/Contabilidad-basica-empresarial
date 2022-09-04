package chamorro.edisson.contabilidad.services;


import chamorro.edisson.contabilidad.entities.MovimientoDinero;
import chamorro.edisson.contabilidad.repositories.DineroRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovimientoDineroServicio {

    DineroRepositorio repositorio;

    public MovimientoDineroServicio(DineroRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<MovimientoDinero> getMovimientos() {
        return this.repositorio.findAll();
    }

    public MovimientoDinero getMovimiento(long id) {
        return this.repositorio.findById(id).get();
    }

    public MovimientoDinero postMovimiento(MovimientoDinero movimientoNuevo) {

        return this.repositorio.save(movimientoNuevo);
    }

    public void patchMovimientoDinero(long id, MovimientoDinero actualizarMovimiento) {
        MovimientoDinero movimientoActualizar = this.repositorio.findById(id).get();
        if (this.repositorio.findById(id).isPresent()) {
            if (actualizarMovimiento.getId()!= 0) movimientoActualizar.setId(actualizarMovimiento.getId());
            if (actualizarMovimiento.getConcepto()!= null) movimientoActualizar.setConcepto(actualizarMovimiento.getConcepto());
            if (actualizarMovimiento.getMonto()!= 0) movimientoActualizar.setMonto(actualizarMovimiento.getMonto());
            this.repositorio.save(movimientoActualizar);
        }
    }

    public void deleteMovimiento(long id) {
        this.repositorio.deleteById(id);
    }
}
