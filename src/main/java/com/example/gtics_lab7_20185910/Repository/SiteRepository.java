package com.example.gtics_lab7_20185910.Repository;
import com.example.gtics_lab7_20185910.dto.TicketsPorSitio;
import com.example.gtics_lab7_20185910.entity.Site;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteRepository extends JpaRepository<Site,Integer> {
    @Query(nativeQuery = true, value = "select s.site as site, count(t.ticket) as cantidadtickets " +
            "FROM site r\n" +
            "left join  s.tickets t" +
            "gruop by s.site\n"
    )
    List<TicketsPorSitio> obtenerTicketsPorSitio();
}
