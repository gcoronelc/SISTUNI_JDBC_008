
chr_cuencodigo
chr_monecodigo
chr_sucucodigo
chr_emplcreacuenta
chr_cliecodigo
dec_cuensaldo
dtt_cuenfechacreacion
vch_cuenestado
int_cuencontmov
chr_cuenclave

select 
	s.chr_sucucodigo codSucursal, 
	s.vch_sucunombre nomSucursal,
	sum( case when c.chr_monecodigo = '01'
	     then c.dec_cuensaldo else 0.0 end ) soles,
	sum( case when c.chr_monecodigo = '02'
	     then c.dec_cuensaldo else 0.0 end ) dolares 
  from cuenta c join sucursal s 
  on c.chr_sucucodigo = s.chr_sucucodigo     
  group by s.chr_sucucodigo, s.vch_sucunombre
  order by 1;


select sum(dec_cuensaldo)
from cuenta
where chr_sucucodigo='001'
and chr_monecodigo='01';






 sucucodigo
 sucunombre
 cliecodigo
 cliepaterno
 cliematerno
 clienombre
 cuencodigo
 cuensaldo
 cuenestado
 movinumero
 movifecha
 moviimporte
 cuenreferencia
 tipocodigo
 tiponombre
 tipoaccion
 monecodigo
 monenombre
 
 
 SELECT TIPOCODIGO, TIPONOMBRE, 
    COUNT(1) CANTMOV, SUM(moviimporte) IMPORTE
 FROM V_MOVIMIENTO
 WHERE SUCUCODIGO='001' AND MONECODIGO='02'
 GROUP BY TIPOCODIGO, TIPONOMBRE;
 
 
 
  select , , 
    count(1) , sum(moviimporte) 
 
 
 
 