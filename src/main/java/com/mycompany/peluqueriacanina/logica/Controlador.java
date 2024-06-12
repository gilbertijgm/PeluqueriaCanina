 
package com.mycompany.peluqueriacanina.logica;
 
import com.mycompany.peluqueriacanina.persistencia.ControladorPersistencia;
import java.util.List;

public class Controlador {
    ControladorPersistencia controlPersis = new ControladorPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDue, String telefono) {
               
        //CREAMOS EL OBJETO DEUÑO Y LE SETEAMOS LOS VALORES QUE LLEGAN DESDE LA INTERFA
        Duenio duenio = new Duenio();
        duenio.setNombre_duenio(nombreDue);
        duenio.setTelefono(telefono);
        
         //CREAMOS EL OBJETO MASCOTA Y LE SETEAMOS LOS VALORES QUE LLEGAN DESDE LA INTERFA
        Mascota mascota = new Mascota();
        mascota.setNombre_mascota(nombreMasco);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencion_esp(atenEsp);
        mascota.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio,mascota);
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.BorrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
       return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota mascota, String nombreMasco, String raza, String color, 
            String observaciones, String alergico, String atenEsp, String nombreDue, String telefono) {
        
        //setamos los nuevos datos al objeto mascota viejo
        mascota.setNombre_mascota(nombreMasco);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setObservacion(observaciones);
        mascota.setAlergico(alergico);
        mascota.setAtencion_esp(atenEsp);
        
        //modifico mascota
        controlPersis.modificarMascota(mascota);
        
        //seteamos los nuevos datos al obejto duenio viejo
        Duenio duenio = this.buscarDuenio(mascota.getUnDuenio().getId_duenio());
        duenio.setNombre_duenio(nombreDue);;
        duenio.setTelefono(telefono);
        
        //modificamos dueño
        this.modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }
}
