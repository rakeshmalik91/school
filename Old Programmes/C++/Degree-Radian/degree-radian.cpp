#include <iostream>

using namespace std;

template <class DT> class Radian;
template <class DT> class Degree;

template <class DT> class Degree {
	DT value;
public:
	Degree(DT);
	DT getValue();
	void setValue(DT);
	operator Radian<DT>();
};
template <class DT> class Radian {
	DT value;
public:
	Radian(DT);
	DT getValue();
	void setValue(DT);
	operator Degree<DT>();
};

template <class DT> Degree<DT>::Degree(DT value=0) {
	Degree::value=value;
}
template <class DT> DT Degree<DT>::getValue() {
	return Degree<DT>::value;
}
template <class DT> void Degree<DT>::setValue(DT value) {
	Degree::value=value;
}
template <class DT> Radian<DT>::operator Degree<DT>() {
	Degree<DT> d;
	d.setValue(Radian::value*180/3.14159265);
	return d;
}
template <class DT> Radian<DT>::Radian(DT value=0) {
	Radian::value=value;
}
template <class DT> DT Radian<DT>::getValue() {
	return Radian::value;
}
template <class DT> void Radian<DT>::setValue(DT value) {
	Radian::value=value;
}
template <class DT> Degree<DT>::operator Radian<DT>() {
	Radian<DT> r;
	r.setValue(Degree::value*3.14159265/180);
	return r;
}

main() {
	Degree<float> d1=45, d2;
	Radian<float> r1, r2=1;
	r1=d1;
	d2=r2;
	cout<<d1.getValue()<<" degree = "<<r1.getValue()<<" radian"<<endl
	    <<d2.getValue()<<" degree = "<<r2.getValue()<<" radian"<<endl;
}
