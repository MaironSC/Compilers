class CodeGen{

	
	float geraCodigo (ArvoreSintatica arv)
	{
		return (geraCodigo2(arv));
	}

	float geraCodigo2 (ArvoreSintatica arv)
	{

	if (arv instanceof Mult)
		return (float) geraCodigo2(((Mult)arv).arg1) * 
			geraCodigo2(((Mult) arv).arg2);

	if (arv instanceof Soma)
		return (float) geraCodigo2(((Soma) arv).arg1) + 
			geraCodigo2(((Soma) arv).arg2);

	if (arv instanceof Sub)
		return (float) geraCodigo2(((Sub) arv).arg1) - 
			geraCodigo2(((Sub) arv).arg2);
  if (arv instanceof Div)
		return (float) geraCodigo2(((Div) arv).arg1) / 
			geraCodigo2(((Div) arv).arg2);
 
	if (arv instanceof Num)
		return (((Num) arv).num );

	return 0;
	}
}
