package hotel.domain;

import hotel.domain.Reserved;
import hotel.ReservationApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Reservation_table")
@Data

public class Reservation  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    private String name;

    @PostPersist
    public void onPostPersist(){


        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();

    }

    public static ReservationRepository repository(){
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(ReservationRepository.class);
        return reservationRepository;
    }






}
