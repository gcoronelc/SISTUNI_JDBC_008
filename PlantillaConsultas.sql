    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
