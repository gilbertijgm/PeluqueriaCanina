 
package com.mycompany.peluqueriacanina.persistencia;
 
import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorPersistencia {
    //-------- CRUD DUEÑO INICIO----------
    DuenioJpaController duenioJpa = new DuenioJpaController();
    //-------- CRUD DUEÑO FIN----------
    
    //-------- CRUD MASCOTA INICIO----------
    MascotaJpaController mascotaJpa = new MascotaJpaController();
     //-------- CRUD MASCOTA FIN----------

    public void guardar(Duenio duenio, Mascota mascota) {
        //GUARDAMOS EN LA BD
        duenioJpa.create(duenio);
        
        mascotaJpa.create(mascota);
    }

    public List<Mascota> traerMascotas() {
        return mascotaJpa.findMascotaEntities();
    }

    public void BorrarMascota(int num_cliente) {
        try {
            mascotaJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int num_cliente) {
       return mascotaJpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota mascota) {
        try {
            mascotaJpa.edit(mascota);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio duenio) {
        try {  
            duenioJpa.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
