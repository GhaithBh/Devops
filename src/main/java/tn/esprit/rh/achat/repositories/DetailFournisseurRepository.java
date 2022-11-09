package tn.esprit.rh.achat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.entities.DetailFournisseur;

@Repository
public interface DetailFournisseurRepository  extends CrudRepository<DetailFournisseur, Long>{

}
