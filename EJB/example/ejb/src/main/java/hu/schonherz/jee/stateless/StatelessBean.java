package hu.schonherz.jee.stateless;

import java.util.Date;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.NoSerializabledVO;
import hu.schonherz.jee.SerializabledVO;
import hu.schonherz.jee.StatelessLocal;
import hu.schonherz.jee.StatelessRemote;
import hu.schonherz.jee.interceptor.SimpleInterceptor;

@Stateless
@Local(StatelessLocal.class)
@Remote(StatelessRemote.class)
@Interceptors(SimpleInterceptor.class)
public class StatelessBean implements StatelessLocal, StatelessRemote {
	private static Log logger = LogFactory.getLog(StatelessBean.class);

	@Override
	public void hello() {
		logger.info("StatelessBean : " + this);
	}

	@Override
	@Asynchronous
	public Future<Date> asynchronousPrintTime() {
		logger.info("call printTime" + new Date());
		try {
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AsyncResult<Date>(new Date());
	}

	@Override
	public Double add(Double a, Double b) {

		return a + b;
	}

	@Override
	public SerializabledVO upperCase(SerializabledVO serializabledVO) {
		SerializabledVO rv = new SerializabledVO();
		rv.setText(serializabledVO.getText().toUpperCase());
		return rv;
	}

	@Override
	public NoSerializabledVO upperCase(NoSerializabledVO serializabledVO) {
		NoSerializabledVO rv = new NoSerializabledVO();
		rv.setText(serializabledVO.getText().toUpperCase());
		return rv;
	}

}
