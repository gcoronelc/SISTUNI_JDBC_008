package pe.egcc.eurekaapp.service.spec;

import java.util.List;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public interface CrudServiceSpec<T> {
  
  T read( String code );
  
  List<T> read(T bean);
  
  void create(T bean);
  
  void update(T bean);
  
  void delete(String code);
  
}
