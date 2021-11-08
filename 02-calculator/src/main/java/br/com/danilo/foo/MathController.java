package br.com.danilo.foo;

import br.com.danilo.foo.exception.UnsupportedMathGenerationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw  new UnsupportedMathGenerationException("Please set numeric value");
        }
        Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw  new UnsupportedMathGenerationException("Please set numeric value");
        }
        Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return sub;
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw  new UnsupportedMathGenerationException("Please set numeric value");
        }
        Double mult = convertToDouble(numberOne) * convertToDouble(numberTwo);
        return mult;
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw  new UnsupportedMathGenerationException("Please set numeric value");
        }
        if ( numberTwo.equals("0")){
            throw  new UnsupportedMathGenerationException("Second value cannot be zero");
        }
        Double div = convertToDouble(numberOne) / convertToDouble(numberTwo);
        return div;
    }

    @RequestMapping(value = "/square/{numberOne}", method = RequestMethod.GET)
    public Double square(@PathVariable("numberOne") String numberOne) throws Exception {

        if (!isNumeric(numberOne)){
            throw  new UnsupportedMathGenerationException("Please set numeric value");
        }
        Double square = Math.sqrt(convertToDouble(numberOne));
        return square;
    }



    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 1D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
