/***************************************************************************
 * Copyright (C) 2018 iObserve Project (https://www.iobserve-devops.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ***************************************************************************/
package org.iobserve.selenium.behavior.tasks.jpetstore.buy;

import java.util.LinkedList;
import java.util.List;

import org.apache.http.conn.ConnectTimeoutException;
import org.iobserve.selenium.behavior.properties.parameter.ListTaskParameter;
import org.iobserve.selenium.behavior.tasks.AbstractTask;
import org.iobserve.selenium.behavior.tasks.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;

/**
 * One task to add a certain amount of one sort of cat to the shopping cart.
 *
 * @author Marc Adolf
 *
 * @deprecated 1.1.0
 */
@Deprecated
public class AddCatsToCartTask extends AbstractTask {

    private final int amount;
    private final ListTaskParameter<String> items;

    /**
     * One task to add a certain amount of one sort of cat to the shopping cart.
     *
     * @param amount
     *            The amount of cat added in one task
     * @param itemPosition
     *            The position of the sort of cat in the list. Is set to the last position if the
     *            itemPosition exceeds the size of the list.
     */
    @Parameters(names = { "amount", "itemPosition" })
    public AddCatsToCartTask(final Integer amount, final Integer itemPosition) {
        this.amount = amount;

        final List<String> givenItems = new LinkedList<>();
        givenItems.add("FL-DSH-01");
        givenItems.add("FL-DLH-02");

        this.items = new ListTaskParameter<>(givenItems, itemPosition);

    }

    /*
     * (non-Javadoc)
     *
     * @see org.iobserve.selenium.tasks.IUserTask#accept(org.openqa.selenium.WebDriver,
     * java.lang.String)
     */
    @Override
    public void executeTask(final WebDriver driver, final String baseUrl, final long activityDelay)
            throws NoSuchSessionException, ConnectTimeoutException {
        driver.get(baseUrl + "/actions/Catalog.action");
        final String item = this.items.getSelectedParameter();
        final int currentAmount = this.amount;

        AbstractTask.LOGGER.info(String.format("DEPRECATED use AddItemToCartTask  %s: item: %s amount: %d ",
                this.getName(), item, currentAmount));

        for (int j = 0; j < currentAmount; j++) {
            driver.findElement(By.xpath("//div[@id='QuickLinks']/a[4]/img")).click();
            this.sleep(activityDelay);
            driver.findElement(By.linkText(item)).click();
            this.sleep(activityDelay);
            driver.findElement(By.linkText("Add to Cart")).click();
            this.sleep(activityDelay);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.iobserve.selenium.tasks.IUserTask#getName()
     */
    @Override
    public String getName() {

        return "Adding cats to cart task";
    }

}
