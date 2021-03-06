package uk.ac.ucl.twitter.search.geo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class EntityAccess {

  @PersistenceContext
  private EntityManager entityManager;

  public LocationEntity findLocationEntityByLocation(final Location location) {
    final TypedQuery<LocationEntity> typedQuery = entityManager
      .createNamedQuery(
        LocationEntity.QUERY_FIND_BY_LOCATION,
        LocationEntity.class
      );
    typedQuery.setParameter(LocationEntity.PARAM_LOCATION, location);
    return typedQuery.getSingleResult();
  }

  public List<ScheduleAppLocationEntity> findAllScheduleAppLocationEntity() {
    final TypedQuery<ScheduleAppLocationEntity> typedQuery = entityManager
      .createNamedQuery(
        ScheduleAppLocationEntity.QUERY_FIND_ALL,
        ScheduleAppLocationEntity.class
      );
    return typedQuery.getResultList();
  }

  public void updateLocationEntity(final LocationEntity locationEntity) {
    entityManager.merge(locationEntity);
  }
}
