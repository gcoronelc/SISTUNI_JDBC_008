
Connection cn = null;
try {
  // Objeto Connection
  cn = AccesoDB.getConnection();
  // Inicio de Tx
  cn.setAutoCommit(false);
  
  
  
  // Confirmar Tx
  cn.commit();
} catch (Exception e) {
  try{
	  // Cancelar Tx
	  cn.rollback();
  } catch(Exception e1){
  }
  throw new RuntimeException(e.getMessage());
} finally{
  try {
	cn.close();
  } catch (Exception e) {
  }
}